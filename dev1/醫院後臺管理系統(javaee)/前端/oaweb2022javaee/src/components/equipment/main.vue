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
		name:"ClientMain",
		data(){
			return {
				clientNo:null,
				title:"設備管理"
			}
		},		
		created(){
			
		},
		methods:{
			toAdd(){	
				let path=this.$route.path;
				
				this.$router.push({name:"clientadd"})				
				
			},
			toModify(){
				if(this.clientNo==null){
					//alert("请选择要修改的設備")
					ElMessageBox.alert('请选择要修改的設備', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.$router.push({name:"clientmodify",params:{no:this.clientNo}});
				}
				
			},
			toDelete(){				
				if(this.clientNo==null){
					//alert("请选择要删除的設備")
					ElMessageBox.alert('请选择要删除的設備', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.axiosJSON.post("/client/delete.do",{no:this.clientNo}).then((result)=>{
						if(result.data.status=="Y"){
							alert(result.data.message);
							this.clientNo=null;
							this.emitter.emit("updateClientList",{"message":"OK"});
						}
						else{
							alert(result.data.message);
						}
					});
				}
				
			},
			toView(){
				if(this.clientNo==null){
					//alert("请选择要查看的設備");
					ElMessageBox.alert('请选择要查看的設備', '操作提示', {
    					// if you want to disable its autofocus
    					// autofocus: false,
    					confirmButtonText: 'OK'
  })

				}
				else{
					this.$router.push({name:"clientview",params:{no:this.clientNo}});
				
				}
				
			}
		}
	}
</script>

<style>
</style>