$(function() {
	var data4Vue = {
		itemList: [],
		listThs: [
			{name: '编号', width: 249, thname: 'id'},
			{name: '名称', width: 1150, thname: 'name'},
			{name: '操作', width: 249, thname: 'operate'}
		],
		dept4Add: {id: 0, name: ""},
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
				if (!_this.dept4Add.name) {
					myzui._error("必填参数不能为空");
					return;
				}
				var url = "depts";
				if (_this.dept4Add.id == 0) {//新增
					axios.post(url, _this.dept4Add).then(function(res) {
						_this.list(1);
						_this.dept4Add = {id: 0, name: ""};
						_this.isEditShow = false;
					});
				} else {//修改
					axios.put(url, _this.dept4Add).then(function(res) {
						_this.list(1);
						_this.dept4Add = {id: 0, name: ""};
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
				this.dept4Add = {id: 0, name: ""};
			},
			updateEdit(dept) {
				this.isEditShow = true;
				this.editTitle = "修改";
				this.dept4Add.id = dept.id;
				this.dept4Add.name = dept.name;
			},
			list(start) {
				var _this = this;
				_this.isLoading = true;
				var url = "depts?start=" + start + "&keyword=" + _this.keyword + "&size=" + _this.size;
				axios.get(url).then(function(res) {
					_this.pagination = res.data;
					_this.itemList = res.data.list;
					_this.isLoading = false;
				});
			},
			deleteItem(id) {
				var _this = this;
				myzui.confirm("确认删除？", function() {
					var url = "depts/" + id;
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