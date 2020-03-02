$(function() {
	var data4Vue = {
		meetings: [],
		meetingDetail: {},
		pagination: {},
		keyword: "",
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
		},
		methods: {
			cancelReservation(id) {
				var _this = this;
				myzui.confirm("确认取消？", function() {
					var url = "cancelReservation/" + id;
					axios.delete(url).then(function(res) {
						myzui._success("已取消预约");
						_this.list(1);
					});
				});
			},
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
				var url = "myMeetings?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.meetings = res.data.list;
					_this.isLoading = false;
				});
			},
			reset: function() {
				var _this = this;
				$("#keyword").val("");
				_this.keyword = $("#keyword").val();
				_this.list(1);
			},
			search: function() {
				var _this = this;
				_this.keyword = $("#keyword").val();
				if (_this.keyword) {
					_this.list(1);
				}
			}
		}
	});
});