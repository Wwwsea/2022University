<template>
	<div>
		<h4>等級修改</h4>
		<form v-on:submit.prevent="modifyWork">
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">等級编码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="work.code" required="required" id="workCode">
			    </div>
			</div>
			<div class="mb-3 row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">等級名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="work.name" required="required" id="workName">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/work/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>

<script>
	export default {
		name:"WorkModify",
		data(){
			return {
				work:{
					no:0,
					code:"",
					name:""
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
			this.$parent.$parent.title="等級管理-等級修改";
			this.getTheWork();
		},
		beforeRouteUpdate(to, from) {
			alert("beforeRouteUpdate")
		},
		methods:{
			getTheWork(){
				this.axiosJSON.get("/work/get.do?no="+this.no).then(result=>{
					this.work=result.data.model;
				});
			},
			modifyWork(){
				this.axiosJSON.post("/work/modify.do",this.work).then((result)=>{
					if(result.data.status=="Y"){
						alert(result.data.message);
						this.$router.push({name:"worklist"});
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