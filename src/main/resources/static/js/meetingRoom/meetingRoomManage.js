$(function() {
	var data4Vue = {
		itemList: [],
		listThs: [
			{name: '编号', width: 249, thname: 'id'},
			{name: '名称', width: 249, thname: 'name'},
			{name: '地址', width: 249, thname: 'address'},
			{name: '会议人数', width: 249, thname: 'count'},
			{name: '设备使用情况', width: 400, thname: 'machine'},
			{name: '操作', width: 249, thname: 'operate'}
		],
		meetingRoom4Add: {id: 0, name: "", address: "", count: 0, machine: "", remark: ""},
		pagination: {},
		keyword: "",
		isEditShow: false,
		isLoading: false,
		editTitle: "",
		size: 15
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			this.list(1);
		},
		methods: {
			save() {
				var _this = this;
				if (!_this.meetingRoom4Add.name) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "meetingRooms";
				if (_this.meetingRoom4Add.id == 0) {//新增
					axios.post(url, _this.meetingRoom4Add).then(function(res) {
						_this.list(1);
						_this.meetingRoom4Add = {id: 0, name: "", address: "", count: 0, machine: "", remark: ""};
						_this.isEditShow = false;
					});
				} else {//修改
					axios.put(url, _this.meetingRoom4Add).then(function(res) {
						_this.list(1);
						_this.meetingRoom4Add = {id: 0, name: "", address: "", count: 0, machine: "", remark: ""};
						_this.isEditShow = false;
					});
				}
			},
			cancel() {
				this.isEditShow = false;
			},
			addEdit() {
				this.isEditShow = true;
				this.editTitle = "新建";
				this.meetingRoom4Add = {id: 0, name: "", address: "", count: 0, machine: "", remark: ""};
			},
			updateEdit(meetingRoom) {
				this.isEditShow = true;
				this.editTitle = "修改";
				this.meetingRoom4Add.id = meetingRoom.id;
				this.meetingRoom4Add.name = meetingRoom.name;
				this.meetingRoom4Add.address = meetingRoom.address;
				this.meetingRoom4Add.count = meetingRoom.count;
				this.meetingRoom4Add.machine = meetingRoom.machine;
				this.meetingRoom4Add.remark = meetingRoom.remark;
			},
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "meetingRooms?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.itemList = res.data.list;
					_this.isLoading = false;
				});
			},
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					var url = "meetingRooms/" + id;
					axios.delete(url).then(function(res) {
						_this.list(1);
					});
				});
			},
			reset() {
				var _this = this;
				$("#keyword").val("");
				_this.keyword = $("#keyword").val();
				_this.list(1);
			},
			search() {
				var _this = this;
				_this.keyword = $("#keyword").val();
				if (_this.keyword) {
					_this.list(1);
				}
			}
		}
	});
});