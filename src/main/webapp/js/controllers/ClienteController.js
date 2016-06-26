var clienteModule = angular.module('cliente', []);

clienteModule.controller('ClienteController',
    function($route, $routeParams, $location) {
        console.log("cliente");
    });