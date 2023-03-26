<template>
	<div>
		<h4>設備修改</h4>
		<form v-on:submit.prevent="modifyClient">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">設備姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="client.name" required="required" id="clientName">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">設備價格</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="client.tel" required="required" id="clientTel">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/client/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
	export default {
		name:"ClientModify",
		data(){
			return {
				client:{
					no:0,
					name:"",
					tel:""
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
			this.$parent.$parent.title="設備管理-設備修改";
			this.getTheClient();
		},
		beforeRouteUpdate(to, from) {
			alert("beforeRouteUpdate")
		},
		methods:{
			getTheClient(){
				this.axiosJSON.get("/client/get.do?no="+this.no).then(result=>{
					this.client=result.data.model;
				});
			},
			modifyClient(){
				this.axiosJSON.post("/client/modify.do",this.client).then((result)=>{
					if(result.data.status=="Y"){
						alert(result.data.message);
						this.$router.push({name:"clientlist"});
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