<template>
	<div>
		<form @submit.prevent="add">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">等級编码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="code" required="required" id="workCode">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">等級名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="name" required="required" id="workName">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/work/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
export default {
	name:"WorkAdd",
	data(){
		return {
			code:"",
			name:""
		};
	},
	created(){
		this.$parent.$parent.title="等級管理-职务增加";
	},
	methods:{
		add(){
			this.axiosJSON.post("/work/add.do",{code:this.code,name:this.name}).then((result)=>{
				if(result.data.status=="Y"){
					alert(result.data.message);
					this.$router.push("/work/list"); //编程方式跳转到等級列表组件
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