<template>
	<div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">設備姓名</label>
			<div class="col-sm-10">
				{{client.name}}
			</div>
		</div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">設備價格</label>
			<div class="col-sm-10">
			  {{client.tel}}
			</div>
		</div>
		<router-link to="/client/list" class="btn btn-secondary">返回</router-link>
		
	</div>
</template>

<script>
	export default {
		name:"ClientView",
		data(){
			return {
				client:{}
			};
		},
		props:{
			no:{				
				required:true
			}
		},
		created(){
			this.$parent.$parent.title="設備管理-設備查看";		
			this.getTheClient();
		},
		methods:{
			getTheClient(){
				this.axiosJSON.get("/client/get.do?no="+this.no).then(result=>{
					this.client=result.data.model;
				});				
			}
		}
	}
</script>

<style>
</style>