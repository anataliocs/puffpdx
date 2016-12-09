(function() {
    'use strict';

    angular
        .module('puffpdxApp')
        .controller('StrainsController', StrainsController);

    StrainsController.$inject = ['$scope', 'StrainsService', '$state'];

    function StrainsController ($scope, StrainsService, $state) {
        var vm = this;
        vm.showLoading = false;

        vm.getAllStrains = function() {
            vm.showLoading = true;

            StrainsService.getStrains({},
                onSuccess, onError);

            function onSuccess(data, headers) {
                vm.strains = data.data;
                vm.showLoading = false;
            }

            function onError(error) {
                //TODO implement
            }
        };

    }

})();


