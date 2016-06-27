var lojaModule = angular.module('loja', []);

lojaModule.service('LojaService',
  function($route, $routeParams, $location) {
    var self = this;
	
	this.produtos = [
		{
			titulo: "Pneu Aro 13 Altimax General",
			descricao: "Esse pneu conta com indicação de desgastes e alinhamento, perfeito para detectar erros e desgastes irregulares. Você terá uma direção muito mais silenciosa, com maior segurança.",
			imgUrl: "http://www.extra-imagens.com.br/automotivo/PneusRodasCalotas/Pneus/3596181/63615637/Pneu-Aro-13-Altimax-General-Tire-RT-175-70-R13-82T-3596181.jpg",
			preco: '149.90',
			codigo: '1'
		},
		{
			titulo: "Computador Positivo All in One",
			descricao: "O computador Positivo Union US2070 é completo para simplificar a sua rotina. O design compacto permite instalar em qualquer ambiente da casa.",
			imgUrl: "http://www.extra-imagens.com.br/Informatica/Computadores/1000059379/275465417/Computador-Positivo-All-in-One-Union-US2070-com-Processador-ARM-Quad-Core-2GB-16GB-Leitor-de-Cartoes-Wireless-Webcam-LED-15-6-e-Android-4-4-1000059379.jpg",
			preco: '698.60',
			codigo: '2'
		},
		{
			titulo: "Ferro a Vapor Arno Ultragliss FU41 com Spray",
			descricao: "O Ferro a Vapor Arno Ultragliss FU41 possui base Durilium que é a melhor do mercado porque combina ótima performance de deslizamento com altíssima resistência a arranhados e ainda evita que o tecido grude e fique com brilho. Com vapor vertical e spray remove até mesmo os vincos mais difíceis de maneira eficiente.",
			imgUrl: "http://www.extra-imagens.com.br/Eletroportateis/FerrodePassar/FerroaVapor/4667690/109386596/Ferro-a-Vapor-Arno-Ultragliss-FU41-com-Spray-Azul-4667690.jpg",
			preco: '138.00',
			codigo: '3'
		},
		{
			titulo: "Umidificador de Ar Digital Elgin Bivolt - 2 Litros",
			descricao: "O Umidificador de Ar Digital Elgin é ideal para você que busca qualidade de vida. Ele possui tecnologia ultrassônica que quebra a molécula de água através de vibrações, transformando-a em névoa. Ideal para ambientes com baixa umidade relativa ou com ar-condicionado, pois reduz os sintomas incômodos do ar seco para pessoas com doenças respiratórias.",
			imgUrl: "http://www.extra-imagens.com.br/ArVentilacao/TratamentodeAr/Umidificadores/5328192/158298825/Umidificador-de-Ar-Digital-Elgin-Bivolt-2-Litros-5328192.jpg",
			preco: '69.00',
			codigo: '4'
		}
	];
	
	this.getProduto = function(codigo) {
		for (var i=0; i<self.produtos.length; i++) {
			if (self.produtos[i].codigo === codigo) {
				return self.produtos[i];
			}
		}
	};
	
});