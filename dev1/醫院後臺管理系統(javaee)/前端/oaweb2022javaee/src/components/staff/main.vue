<template>
	<!-- Default box -->
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">{{title}}</h3>
			<div class="card-tools">
			  <router-link to="/manager/add" class="btn btn-dark"><i class="fas fa-adjust"></i>增加</router-link>
			  <a href="#" @click.prevent="toModify" class="btn btn-dark"><i class="fas fa-minus"></i>修改</a>
			  <a href="#" @click.prevent="toDelete" class="btn btn-dark"><i class="fas fa-minus"></i>删除</a>
			  <a href="#" @click.prevent="toView" class="btn btn-dark"><i class="fas fa-minus"></i>查看</a>
			</div>
		</div>
		<div class="card-body">
			<router-view></router-view>
		</div>
	</div>
	  <!-- /.card-body -->
</template>

<script>
import { ElMessage, ElMessageBox } from 'element-plus'
export default {
	name:"ManagerMain",
	data(){
		return {
			title:"雇員管理",
			managerId:null
		}
	},
	created(){
		
	},
	methods:{
		toModify(){
			if(this.managerId==null){
				//alert("请选中要修改的雇員");
				ElMessageBox.alert('请选择要修改的雇員', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
			}
			else{
				this.$router.push("/manager/modify/"+this.managerId);
			}
		},
		toDelete(){
			if(this.managerId==null){
				//alert("请选中要删除的雇員");
				ElMessageBox.alert('请选择要删除的雇員', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
			}
			else{
				this.axiosJSON.post("/manager/delete.do",{id:this.managerId}).then(result=>{
					alert(result.data.message);	
					if(result.data.status=="Y"){
						this.emitter.emit("updateManagerList",{message:"删除雇員成功"});
					}
				});
			}
		},
		toView(){
			if(this.managerId==null){
				//alert("请选中要查看的雇員");
				ElMessageBox.alert('请选择要查看的雇員', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
			}
			else{
				this.$router.push("/manager/view/"+this.managerId);
			}
		}
	}
}
</script>

<style>
</style>