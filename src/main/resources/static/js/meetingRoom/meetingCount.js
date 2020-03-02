$(function() {
	var data4Vue = {
		meetings: [],
		meetingDetail: {},
		pagination: {},
		date: "",
		isEditShow: false,
		isLoading: false,
		size: 15,
		checkboxAllFlag: false,
		editTitle: "",
		detailTitle: ""
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
			$("#date").datetimepicker({
				weekStart: 1,
				todayBtn: 1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0,
				format: "yyyy-mm-dd"
			});
		},
		methods: {
			detail(meeting) {
				var _this = this;
				$("#detailModal").modal({
					show: true
				});
				this.meetingDetail = meeting;
			},
			checkboxAll() {
				if (!this.checkboxAllFlag) {
					$(".checkbox-parent").addClass("checked");
					$(".checkbox-children").addClass("checked");
					this.checkboxAllFlag = true;
				} else {
					$(".checkbox-parent").removeClass("checked");
					$(".checkbox-children").removeClass("checked");
					this.checkboxAllFlag = false;
				}
			},
			checkbox(e) {
				var el = e.target;
				$(el).parent(".checkbox-primary").toggleClass("checked");
				var allFlag = true;
				$(".checkbox-children").map(function(item, ele) {
					if (!$(ele).hasClass("checked")) {
						allFlag = false;
					}
				});
				if (allFlag) {
					$(".checkbox-parent").addClass("checked");
				} else {
					$(".checkbox-parent").removeClass("checked");
				}
			},
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "meetingCounts?start=" + start + "&date=" + _this.date + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.meetings = res.data.list;
					_this.isLoading = false;
				});
			},
			reset() {
				var _this = this;
				$("#date").val("");
				_this.date = $("#date").val();
				_this.list(1);
			},
			search() {
				var _this = this;
				_this.date = $("#date").val();
				if (_this.date) {
					_this.list(1);
				}
			}
		}
	});
});