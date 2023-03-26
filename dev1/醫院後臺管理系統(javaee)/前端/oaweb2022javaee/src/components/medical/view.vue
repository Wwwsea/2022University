<template>
	<div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">藥物名称</label>
			<div class="col-sm-10">
				{{dish.name}}
			</div>
		</div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">藥物价格</label>
			<div class="col-sm-10">
			  {{dish.price}}
			</div>
		</div>
		<router-link to="/dish/list" class="btn btn-secondary">返回</router-link>
		
	</div>
</template>

<script>
	export default {
		name:"DishView",
		data(){
			return {
				dish:{}
			};
		},
		props:{
			no:{				
				required:true
			}
		},
		created(){
			this.$parent.$parent.title="藥物管理-藥物查看";		
			this.getTheDish();
		},
		methods:{
			getTheDish(){
				this.axiosJSON.get("/dish/get.do?no="+this.no).then(result=>{
					this.dish=result.data.model;
				});				
			}
		}
	}
</script>

<style>
</style>