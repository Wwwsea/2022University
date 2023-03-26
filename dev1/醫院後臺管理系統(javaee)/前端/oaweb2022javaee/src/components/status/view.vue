<template>
	<div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">等級编码</label>
			<div class="col-sm-10">
				{{work.code}}
			</div>
		</div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">等級名称</label>
			<div class="col-sm-10">
			  {{work.name}}
			</div>
		</div>
		<router-link to="/work/list" class="btn btn-secondary">返回</router-link>
		
	</div>
</template>

<script>
	export default {
		name:"WorkView",
		data(){
			return {
				work:{}
			};
		},
		props:{
			no:{				
				required:true
			}
		},
		created(){
			this.$parent.$parent.title="等級管理-等級查看";		
			this.getTheWork();
		},
		methods:{
			getTheWork(){
				this.axiosJSON.get("/work/get.do?no="+this.no).then(result=>{
					this.work=result.data.model;
				});				
			}
		}
	}
</script>

<style>
</style>