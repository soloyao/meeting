$(function() {
	var data4Vue = {
		user4Register: {name: "", password: ""}	
	};
	
	var vue = new Vue({
		el: "#app",
		data: data4Vue,
		mounted: function() {
			$("#register-name").get(0).select();
		},
		methods: {
			registerKeyDown: function(e) {
				if (e.keyCode == 13) {
					this.register();
				}
			},
			login: function() {
				window.location.href = "login";
			},
			register: function() {
				var _this = this;
				var url = "register";
				if (!_this.user4Register.name || !_this.user4Register.password) {
					myzui._error1("用户名或密码不能为空");
					return;
				}
				axios.post(url, _this.user4Register).then(function(res) {
					var data = res.data;
					if (data.code == "0") {
						myzui._success1("注册成功，正在为你跳转至登录页面");
						setTimeout(() => {
							location.href = "login";
						}, 1000);
					} else {
						myzui._error1(data.msg);
					}
				});
			}
		}
	});
});