'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'loja',
    'ui.router',
    'carrinho',
    'cliente'
]).
config(['$routeProvider', function($routeProvider) {

    $routeProvider
        .when('/loja', {
            templateUrl: 'partials/loja.html',
            controller: 'LojaController',
            controllerAs: 'lojaCtrl'
        }).when('/carrinho', {
            templateUrl: 'partials/carrinho.html',
            controller: 'CarrinhoController',
            controllerAs: 'carrinhoCtrl'
        }).when('/perfil', {
            templateUrl: 'partials/perfil.html',
            controller: 'ClienteController',
            controllerAs: 'clienteCtrl'
        }).otherwise({ redirectTo: '/loja' });;

}]);