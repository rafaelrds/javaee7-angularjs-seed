var lojaModule = angular.module('loja');

lojaModule.controller('LojaController',
    function($route, $routeParams, $location, LojaService, CarrinhoService) {

        var self = this;

        this.produtos = LojaService.produtos;

        this.adicionarNoCarrinho = function(codigo) {
            if (CarrinhoService.carrinho[codigo] === undefined) {
                CarrinhoService.carrinho[codigo] = 1;
            } else {
                CarrinhoService.carrinho[codigo] += 1;
            }
        };
    });