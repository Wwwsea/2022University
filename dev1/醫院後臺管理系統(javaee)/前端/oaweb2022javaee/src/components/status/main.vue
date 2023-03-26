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
		name:"WorkMain",
		data(){
			return {
				workNo:null,
				title:"等級管理"
			}
		},		
		created(){
			
		},
		methods:{
			toAdd(){	
				let path=this.$route.path;
				
				this.$router.push({name:"workadd"})				
				
			},
			toModify(){
				if(this.workNo==null){
					//alert("请选择要修改的等級")
					ElMessageBox.alert('请选择要修改的等級', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.$router.push({name:"workmodify",params:{no:this.workNo}});
				}
				
			},
			toDelete(){				
				if(this.workNo==null){
					//alert("请选择要删除的等級")
					ElMessageBox.alert('请选择要删除的等級', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.axiosJSON.post("/work/delete.do",{no:this.workNo}).then((result)=>{
						if(result.data.status=="Y"){
							alert(result.data.message);
							this.workNo=null;
							this.emitter.emit("updateWorkList",{"message":"OK"});
						}
						else{
							alert(result.data.message);
						}
					});
				}
				
			},
			toView(){
				if(this.workNo==null){
					//alert("请选择要查看的等級");
					ElMessageBox.alert('请选择要查看的等級', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.$router.push({name:"workview",params:{no:this.workNo}});
				
				}
				
			}
		}
	}
</script>

<style>
</style>