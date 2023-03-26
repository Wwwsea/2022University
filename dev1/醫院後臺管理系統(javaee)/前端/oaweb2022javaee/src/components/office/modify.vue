<template>
	<div>
		<form @submit.prevent="modifyArea()">
			<div class="mb-3 row">
			    <label class="col-sm-2 col-form-label">部門名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" v-model="area.name" required="required">
			    </div>
			</div>
			<button type="submit" class="btn btn-secondary">提交</button> | 
			<router-link to="/area/list" class="btn btn-secondary">返回</router-link>
		</form>
	</div>
</template>
	
<script>
	export default {
		name:"AreaModify",
		data(){
			return {
				area:{
					no:0,					
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
			this.$parent.$parent.title="部門修改";
			//this.getBehave();  //取得Server端数据
		},		
		methods:{
			getArea(){
				this.axiosJSON.get("/area/get.do?no="+this.no).then(result=>{
					this.area=result.data.model;
				});
				
			},
			modifyArea(){
				this.axiosJSON.post("/area/modify.do",this.area).then((result)=>{
					if(result.data.status=="Y"){
						alert(result.data.message);
						this.$router.push("/area/list"); //编程方式跳转到部门列表组件
					}
					else{
						alert(result.data.message);
					}
				});
			}
		},
		beforeRouteEnter(to,from,next){
			//通过路由守卫 fetch服务器端的数据。
			console.log("beforeRouteEnter路由守卫");
			next(vm=>{
				vm.axiosJSON.get("/area/get.do?no="+to.params.no).then(result=>{
					vm.area=result.data.model;
				});
				
			});
			
		}
	}
</script>

<style>
</style>