package br.edu.ufcg.splab.test;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.SecureRandom;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.testng.annotations.BeforeMethod;

import br.edu.ufcg.splab.pojo.client.Client;
import br.edu.ufcg.splab.pojo.shopping.Product;

@ArquillianSuiteDeployment
public abstract class ArquillianTestSuite extends Arquillian {

	private SecureRandom random = new SecureRandom();

	@BeforeMethod
	public void setUp() {

	}

	@Deployment
	public static Archive<?> createDeployment() {
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
				.withTransitivity().asFile();

		return ShrinkWrap.create(WebArchive.class, "app.war").setWebXML("web.xml")
				.addPackages(true, "br.edu.ufcg.splab", "com.google.common").addAsResource("META-INF/persistence.xml")
				.addAsResource("import.sql").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("example-ds.xml").addAsWebInfResource("jboss-deployment-structure.xml")
				.addAsLibraries(files);
	}

	public static void main(String[] args) {
		createDeployment().writeTo(System.out, Formatters.VERBOSE);
	}
	
	public String getRandomString() {
		return new BigInteger(130, random).toString(32);
	}

	protected Product getDefaultProduct() {
		Product product = new Product("Pneu Aro 13 Altimax General",
				"Esse pneu conta com indicação de desgastes e alinhamento, perfeito para detectar erros e desgastes irregulares. Você terá uma direção muito mais silenciosa, com maior segurança.",
				"http://www.extra-imagens.com.br/automotivo/PneusRodasCalotas/Pneus/3596181/63615637/Pneu-Aro-13-Altimax-General-Tire-RT-175-70-R13-82T-3596181.jpg",
				new Double(149.90));
		return product;
	}
	
	protected Product getRandomProduct() {
		Product product = new Product(getRandomString(),
				getRandomString(),
				getRandomString(),
				new Double(100 * random.nextDouble()));
		return product;
	}

	protected Client getDefaultClient() {
		Client client = new Client("Arthur", "marques.art@gmail.com");
		return client;
	}
	
	protected Client getRandomClient() {
		Client client = new Client(getRandomString(), String.format("%s@gmail.com", getRandomString()));
		return client;
	}
	
	protected URI getURI(URL base, String ...resources){
		URL restURI = null;
		StringBuilder path = new StringBuilder("api");
		for (String resource: resources){
			if (!resource.contains("/")){
				path.append("/");
			}
			path.append(resource);
		}
		try {
			restURI = new URL(base, path.toString());
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error building resource url", e);
		}
		return URI.create(restURI.toExternalForm());
	}
}
