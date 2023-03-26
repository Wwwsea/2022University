<template>
	<div class="row">
		<div class="col-sm-6">
			<label for="inputPassword" class="col-sm-2 col-form-label">部門名称</label>
		</div>
		<div class="col-sm-6">
			  {{area.name}}
		</div>
		<router-link to="/area/list" class="btn btn-secondary">返回</router-link>
	</div>
</template>

<script>
	export default {
		name:"AreaView",
		data(){
			return {
				area:{}
			};
		},
		props:{
			no:{				
				required:true
			}
		},
		mounted(){
			this.$parent.$parent.title="部門管理-部門查看";
			this.getArea();
		},
		methods:{
			getArea(){
				this.axiosJSON.get("/area/get.do?no="+this.no).then(result=>{
					this.area=result.data.model;
				});
				
			}
		}
	}
</script>

<style>
</style>