define(
		[ 'app' ],
		function(app) {

			var injectParams = [ '$scope', '$http', '$location' ];

			var IndexController = function($scope, $http, $location) {
				$scope.user = {};
				$scope.processedData = {};
				$scope.processedData.sortedNumbers = [];
				$scope.previousData = [];
				$scope.homePage = {
					'inputLabel' : 'Please enter the numbers to be sorted (seperated by comma)',
					'outputLabel' : 'Sorted Numbers are : ',
					'processingTimeLabel' : 'Processing Time in milisecond(s) : ',
					'numberOfSwaps' : 'Number of swaping done :',
					'serialNumber' : 'S.No.',
					'previousUserInputColumnName' : 'Input Values',
					'previousResultColumnName' : 'Sorted Values',
					'previousResultsLabel' : 'Previous Results'
				};

				$http
						.post('rest/fetchPreviousResults')
						.success(
								function(data) {
									for (var index = 0; index < data.length; index++) {
										$scope.previousData
												.push({
													'serialNo' : data[index].serialNo,
													'inputValue' : data[index].inputValues,
													'sortedNumbers' : data[index].sortedNumbers
												});
									}

								}).error(function(data) {
						});

				$scope.sortUserInput = function() {
					$http
							.post('rest/performSorting', $scope.user)
							.success(
									function(data) {
										for (var index = 0; index < data.sortedNumbers.length; index++) {
											$scope.processedData.sortedNumbers
													.push({
														'index' : index,
														'value' : data.sortedNumbers[index]
													});
										}

										$scope.processedData.processingTime = data.processingTime;
										$scope.processedData.swapCount = data.swapCount;
									}).error(function(data) {
							});

				}

			};
			IndexController.$inject = injectParams;

			app.controller('IndexController', IndexController);

		});
