<template>
	<div>
		<form @submit.prevent="add">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">部門名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="name" required="required" id="workName">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button>  &nbsp;&nbsp;&nbsp;
			<router-link to="/area/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
	export default {
		name:"AreaAdd",
		data(){
			return {
				name:""
			};
		},
		methods:{
			add(){
				this.axiosJSON.post("/area/add.do",{name:this.name}).then((result)=>{
					if(result.data.status=="Y"){
						alert(result.data.message);
						this.$router.push("/area/list"); //编程方式跳转到部門列表组件
					}
					else{
						alert(result.data.message);
					}
				});
			}
			
		}
	}
</script>

<style>
</style>