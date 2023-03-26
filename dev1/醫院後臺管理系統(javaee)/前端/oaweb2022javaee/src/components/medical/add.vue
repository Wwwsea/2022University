<template>
	<div>
		<form @submit.prevent="add">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">藥物名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="name" required="required" id="dishName">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">藥物价格</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" 
				  pattern="^[0-9]+(.[0-9]{1,4})?$" title="藥品價格過高您確定？"
				  v-model="price" required="required" id="dishPrice">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/dish/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
export default {
	name:"DishAdd",
	data(){
		return {
			name:"",
			price:""
		};
	},
	created(){
		this.$parent.$parent.title="藥物管理-藥物增加";
	},
	methods:{
		add(){
			this.axiosJSON.post("/dish/add.do",{name:this.name,price:this.price}).then((result)=>{
				if(result.data.status=="Y"){
					alert(result.data.message);
					this.$router.push("/dish/list"); //编程方式跳转到藥物列表组件
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