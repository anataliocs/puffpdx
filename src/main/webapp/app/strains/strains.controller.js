(function() {
    'use strict';

    angular
        .module('puffpdxApp')
        .controller('StrainsController', StrainsController);

    StrainsController.$inject = ['$scope', 'StrainsService', '$state'];

    function StrainsController ($scope, StrainsService, $state) {
        var vm = this;

        StrainsService.getStrains({},
            onSuccess, onError);

        function onSuccess(data, headers) {
            vm.strains = data.data;
            //alert("response1 " + JSON.stringify(vm.strains));
        }

        function onError(error) {
            //TODO implement
        }
    }

})();
