var lojaModule = angular.module('loja');

lojaModule.directive('itemProduto', function() {
    return {
        restrict: 'A',
        scope: {
            produto: '=',
            adicionarProduto: '&'
        },
        templateUrl: 'js/directives/itemProduto.html',
        link: function(scope, CarrinhoService) {

            scope.adicionarNoCarrinho = function(codigo) {
                scope.adicionarProduto()(codigo);
            };

        }
    };
});