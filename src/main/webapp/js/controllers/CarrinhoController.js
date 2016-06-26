var carrinhoModule = angular.module('carrinho');

carrinhoModule.controller('CarrinhoController',
    function(CarrinhoService, LojaService) {
        var self = this;

        this.total;

        this.listaProdutos = [];

        this.carrinho = CarrinhoService.carrinho;

        this.getProduto = function(codigo) {
            return LojaService.getProduto(codigo);
        };

        this.calculaTotalCarrinho = function() {
            var total = 0;
            for (var i = 0; i < this.listaProdutos.length; i++) {

                var produto = this.listaProdutos[i];
                if (this.carrinho[produto.codigo] !== undefined) {
                    total += (parseInt(produto.preco) * this.carrinho[produto.codigo]);
                }
            }
            return total;
        };

        this.removeItem = function(codigo) {
            this.carrinho[codigo]--;
            if (this.carrinho[codigo] === 0) {
                delete this.carrinho[codigo];
            }
        };

        (function main() {
            var codigos = Object.keys(self.carrinho);
            for (var i = 0; i < codigos.length; i++) {
                var produto = self.getProduto(codigos[i]);
                self.listaProdutos.push(produto);
            }
            self.total = self.calculaTotalCarrinho();
        })();
    });