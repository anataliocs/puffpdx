(function() {
    'use strict';

    angular
        .module('puffpdxApp')
        .controller('StrainsController', StrainsController);

    StrainsController.$inject = ['$scope', 'Principal', 'LoginService', '$state'];

    function StrainsController ($scope, LoginService, $state) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;

        function getStrains () {
            //TODO Update this
            alert("test");
        }
    }
})();
