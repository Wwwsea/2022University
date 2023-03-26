<template>
	<!-- Main Sidebar Container -->
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
	  <!-- Brand Logo -->
	  <a href="#" class="brand-link">
	    <span class="brand-text font-weight-light"><b>醫院後臺系统</b></span>
	  </a>
	
	  <!-- Sidebar -->
	  <div class="sidebar">
	    <!-- Sidebar user (optional) -->
	    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
	      <div class="info" v-if="$store.state.user!=null">
	        <a href="#" class="brand-text font-weight-light">尊敬的“{{$store.state.user.name}}"用戶</a><br/>
			<!--<a href="#" class="brand-text font-weight-light">登录用户:{{piniastore.loginUserName}}</a><br/>-->
			<a href="#" class="d-block" @click="userLogout">====注銷====</a>
			<a href="#" class="d-block" >登入時間: {{enterTime}}</a>
			<!-- <span>登錄時間：{{enterTime}}</span> -->
	      </div>
		  <div class="info" v-else>
		    <a href="#" class="brand-text font-weight-light">用户未登录</a>
		  	<a href="#" class="d-block" @click="userLogin">登录</a>
		  </div>
	    </div>
	
	    <!-- Sidebar Menu -->
	    <nav class="mt-2">
	      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
	        <!-- Add icons to the links using the .nav-icon class
	             with font-awesome or any other icon font library -->
	        <li class="nav-item">
	            <router-link to="/" class="nav-link">
	            <i class="nav-icon fas fa-tachometer-alt"></i>
	            <p>
	              系统主页
	              <i class="right fas fa-angle-left"></i>
	            </p>
	          </router-link> 
	        </li>

			<li class="nav-item">
	            <router-link to="/dish" class="nav-link">
	            <i class="nav-icon fas fa-tree"></i>
	            <p>
	              藥物管理@-@
	              <i class="right fas fa-angle-left"></i>
	            </p>
	          </router-link> 
	        </li>

			<li class="nav-item">
	            <router-link to="/client" class="nav-link">
	            <i class="nav-icon fas fa-tree"></i>
	            <p>
	              設備管理
	              <i class="right fas fa-angle-left"></i>
	            </p>
	          </router-link> 
	        </li>


	        <li class="nav-item">
	          <router-link to="/work" class="nav-link">
	            <i class="nav-icon fas fa-chart-pie"></i>
	            <p>
	              等級管理
	              <i class="right fas fa-angle-left"></i>
	            </p>
	          </router-link>             
	        </li>
	        <li class="nav-item">
	          <router-link to="/area" class="nav-link">
	            <i class="nav-icon fas fa-edit"></i>
	            <p>
	              科室管理
	              <i class="fas fa-angle-left right"></i>
	            </p>
	          </router-link>             
	        </li>
	        <li class="nav-item">
	          <router-link to="/manager" class="nav-link">
	            <i class="nav-icon fas fa-edit"></i>
	            <p>
	              雇員管理→。→
	              <i class="fas fa-angle-left right"></i>
	            </p>
	          </router-link>            
	        </li>
	      </ul>
		  
	    </nav>
		<div class="clock"><span style="text-align: center;"><font color="green">北京時間：{{times}}</font></span></div>
	    <!-- /.sidebar-menu -->
	  </div>
	  <!-- /.sidebar -->
	</aside>
</template>

<script>
	export default {
		name:"LeftMenu",
		data(){
			return{
				enterTime:'',
				times:'',
			}
		},
		methods:{
			userLogout(){
				this.axiosJSON.get("/manager/logout.do").then(result=>{
					this.$store.dispatch("logoutUser");
					//
					this.piniastore.logoutUser(); //注销
					this.$router.push("/login");
					
				});
			},
			userLogin(){
				this.$router.push("/login");
			},
			 getTimes(){
			      setInterval(this.getTimesInterval, 1000);
			    },
			    getTimesInterval:function() {
			      let _this = this;
			      let year = new Date().getFullYear(); //获取当前时间的年份
			      let month = new Date().getMonth() + 1; //获取当前时间的月份
			      let day = new Date().getDate(); //获取当前时间的天数
			      let hours = new Date().getHours(); //获取当前时间的小时
			      let minutes = new Date().getMinutes(); //获取当前时间的分数
			      let seconds = new Date().getSeconds(); //获取当前时间的秒数
			      //当小于 10 的是时候，在前面加 0
			      if (hours < 10) {
			        hours = "0" + hours;
			      }
			      if (minutes < 10) {
			        minutes = "0" + minutes;
			      }
			      if (seconds < 10) {
			        seconds = "0" + seconds;
			      }
			      //拼接格式化当前时间
			      _this.times = year + "年" + month + "月" + day + "日" + hours + ":" + minutes + ":" + seconds;
			    },
		},
		created(){
			//獲取登錄時間
			var _this = this;
			let yy = new Date().getFullYear();
			let mm = new Date().getMonth()+1;
			let dd = new Date().getDate();
			let hh = new Date().getHours();
			let mf = new Date().getMinutes()<10 ? '0'+new Date().getMinutes() : new Date().getMinutes();
			let ss = new Date().getSeconds()<10 ? '0'+new Date().getSeconds() : new Date().getSeconds();
			_this.gettime = yy+'/'+mm+'/'+dd+' '+hh+':'+mf+':'+ss;
			console.log(_this.gettime)  
			this.enterTime=_this.gettime;
			
			this.getTimes()
		},
		// 在Vue实例销毁前，清除我们的定时器
		  beforeDestroy() {
		    if (this.times) {
		      clearInterval(this.getTimesInterval); 
		    }
		  },
		
	}
</script>

<style>
	.clock{
		width: 200px;
		height: 50px;
		margin-left: 20px;
		margin-top: 125px;
		background-color: ghostwhite;
		border-radius: 10px;
		box-shadow: 0 10px 50px rgba(0,0,0,0.3);
	}
</style>