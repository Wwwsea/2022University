<template>
	<div>
		<form @submit.prevent="add">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">設備姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="name" required="required" id="clientName">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">設備價格</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="tel" required="required" id="clientTel">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/client/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
export default {
	name:"ClientAdd",
	data(){
		return {
			name:"",
			tel:""
		};
	},
	created(){
		this.$parent.$parent.title="設備管理-設備增加";
	},
	methods:{
		add(){
			this.axiosJSON.post("/client/add.do",{name:this.name,tel:this.tel}).then((result)=>{
				if(result.data.status=="Y"){
					alert(result.data.message);
					this.$router.push("/client/list"); //编程方式跳转到設備列表组件
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