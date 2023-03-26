<template>
	<!-- Default box -->
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">{{title}}</h3>
			<div class="card-tools">
				
				<button type="button" class="btn btn-secondary" @click="toAdd">增加</button>
				<button type="button" class="btn btn-secondary" @click="toModify">修改</button>
				<button type="button" class="btn btn-secondary" @click="toDelete">删除</button>
				<button type="button" class="btn btn-secondary" @click="toView">查看</button>
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
	name:"AreaMain",
	data(){
		return {
			title:"部門管理",
			areaNo:null
		}
	},
	created(){		
	},
	methods:{
		toAdd(){
			this.$router.push("/area/add");
		},
		
		toModify(){
			if(this.areaNo==null){
				//alert("请选中要修改的部門");
				ElMessageBox.alert('请选择要修改的部門', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
			}
			else{
				this.$router.push("/area/modify/"+this.areaNo);
			}
		},
		toDelete(){
			if(this.areaNo==null){
				//alert("请选中要删除的部門");
				ElMessageBox.alert('请选择要删除的部門', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
			}
			else{
				this.axiosJSON.post("/area/delete.do",{no:this.areaNo}).then((result)=>{
					if(result.data.status=="Y"){
						alert(result.data.message);
						this.areaNo=null; 
						this.emitter.emit("updateAreaList",{"message":"OK"});
					}
					else{
						alert(result.data.message);
					}
				});
			}
			
		},
		toView(){
			if(this.areaNo==null){
				//alert("请选中要查看的部門");
				ElMessageBox.alert('请选择要查看的部門', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
			}
			else{
				this.$router.push("/area/view/"+this.areaNo);
			}
		}
	}
}
</script>

<style>
</style>