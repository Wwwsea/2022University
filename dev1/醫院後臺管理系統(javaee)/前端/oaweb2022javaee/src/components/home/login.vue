<template>
	<div class="login-box">
	  <!-- /.login-logo -->
	  <div class="login-box-body">
	    <p class="login-box-msg">请登录</p>
	
	    <form @submit.prevent="validate">
	      <div class="form-group has-feedback">
	        <input type="text" v-model="id" class="form-control" required placeholder="账号">
	        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	      </div>
	      <div class="form-group has-feedback">
	        <input type="password" class="form-control" v-model="password" required placeholder="密码">
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      </div>
	      <div class="row">
	        <div class="col-xs-12">
	          <div class="checkbox icheck">
	            <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
	          </div>
	        </div>
	        <!-- /.col -->
	      </div>
	    </form>
	  </div>
	  <!-- /.login-box-body -->
	</div>
</template>

<script>
	export default {
		name:"UserLogin",
		data(){
			return {
				id:"",
				password:"",
			}
		},
		methods:{
			validate(){
				this.axiosJSON.post("/manager/validate.do",{id:this.id,password:this.password}).then(result=>{
					
					if(result.data.status=="Y"){
						//通过Vuex状态存储登录的用户信息
						this.$store.dispatch("loginUser",result.data.model); 
						//将登录用户的EmployeeModel对象保存到Pinia Store
						this.piniastore.loginUser(result.data.model); 
						this.$router.push("/");
					}
					else{
						alert(result.data.message);
						this.id="";
						this.password="";
					}
				});
			}
		}
	}
</script>

<style>
</style>