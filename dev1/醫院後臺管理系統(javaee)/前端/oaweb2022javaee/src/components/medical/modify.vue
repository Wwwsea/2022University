<template>
	<div>
		<h4>藥物修改</h4>
		<form v-on:submit.prevent="modifyDish">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">藥物名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="dish.name" required="required" id="dishName">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">藥物价格</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="dish.price" required="required" id="dishPrice">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/dish/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
	export default {
		name:"DishModify",
		data(){
			return {
				dish:{
					no:0,
					name:"",
					price:""
				},				
			};
		},
		props:{
			no:{
				type:String,
				default:null
			}
		},
		created(){
			this.$parent.$parent.title="藥物管理-藥物修改";
			this.getTheDish();
		},
		beforeRouteUpdate(to, from) {
			alert("beforeRouteUpdate")
		},
		methods:{
			getTheDish(){
				this.axiosJSON.get("/dish/get.do?no="+this.no).then(result=>{
					this.dish=result.data.model;
				});
			},
			modifyDish(){
				this.axiosJSON.post("/dish/modify.do",this.dish).then((result)=>{
					if(result.data.status=="Y"){
						alert(result.data.message);
						this.$router.push({name:"dishlist"});
						//this.$router.push("/department/list"); //编程方式跳转到部门列表组件
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