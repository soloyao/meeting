$(function() {
	var data4Vue = {
		meetingRooms: [],
		users: [],
		pagination: {},
		meeting4Add: {id: 0, title: "", useMachine: "0", startTime: "", endTime: "", important: "0", users: ""},
		keyword: "",
		isEditShow: false,
		isLoading: false,
		isUserLoading: false,
		size: 15,
		checkboxAllFlag: false,
		applyTitle: ""
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
			$("#endTime").datetimepicker({
				weekStart: 1,
				todayBtn: 1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				forceParse: 0,
				showMeridian: 1,
				format: "yyyy-mm-dd hh:ii"
			});
		},
		methods: {
			userClick(user) {
				
			},
			applyConfirm() {
				var _this = this;
				var str = $(".userTbody .checked").map(function(item, ele) {
					return $(ele).data("id");
				}).get().join(",");
				this.meeting4Add.startTime = $("#startTime").val();
				this.meeting4Add.endTime = $("#endTime").val();
				this.meeting4Add.users = str;
				var url = "meetingApply";
				if (!_this.meeting4Add.title || !_this.meeting4Add.startTime || !_this.meeting4Add.endTime || !_this.meeting4Add.users) {
					myzui._error("必填参数不能为空");
					return;
				}
				axios.post(url, _this.meeting4Add).then(function(res) {
					$("#applyModal").modal("hide");
					myzui._success("申请成功，请等待管理员审批");
					_this.meeting4Add = {id: 0, title: "", useMachine: "0", startTime: "", endTime: "", important: "0", users: ""};
				});
			},
			apply(meetingRoom) {
				var _this = this;
				$("#applyModal").modal({
					show: true
				});
				$("#startTime").val(new Date().format("yyyy-MM-dd HH:mm"));
				this.meeting4Add.meetingRoomId = meetingRoom.id;
				this.applyTitle = meetingRoom.name + "-会议申请";
				_this.isUserLoading = true;
				var url = "freeUsers";
				axios.get(url).then(function(res) {
					_this.users = res.data;
					_this.isUserLoading = false;
				});
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
				var url = "meetingRooms?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.meetingRooms = res.data.list;
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
	

	Date.prototype.format = function(format){
	    var o = {
	        "M+" : this.getMonth()+1, //month
	        "d+" : this.getDate(), //day
	        "H+" : this.getHours(), //hour
	        "m+" : this.getMinutes(), //minute
	        "s+" : this.getSeconds(), //second
	        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
	        "S" : this.getMilliseconds() //millisecond
	    }
	 
	    if(/(y+)/.test(format)) {
	        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	    }
	 
	    for(var k in o) {
	        if(new RegExp("("+ k +")").test(format)) {
	            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
	        }
	    }
	    return format;
	}
});