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
		name:"DishMain",
		data(){
			return {
				dishNo:null,
				title:"藥物管理"
			}
		},		
		created(){
			
		},
		methods:{
			toAdd(){	
				let path=this.$route.path;
				
				this.$router.push({name:"dishadd"})				
				
			},
			toModify(){
				if(this.dishNo==null){
					//alert("请选择要修改的藥物")
					ElMessageBox.alert('请选择要修改的藥物', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.$router.push({name:"dishmodify",params:{no:this.dishNo}});
				}
				
			},
			toDelete(){				
				if(this.dishNo==null){
					//alert("请选择要删除的藥物")
					ElMessageBox.alert('请选择要删除的藥物', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.axiosJSON.post("/dish/delete.do",{no:this.dishNo}).then((result)=>{
						if(result.data.status=="Y"){
							alert(result.data.message);
							this.dishNo=null;
							this.emitter.emit("updateDishList",{"message":"OK"});
						}
						else{
							alert(result.data.message);
						}
					});
				}
				
			},
			toView(){
				if(this.dishNo==null){
					//alert("请选择要查看的藥物");
					ElMessageBox.alert('请选择要查看的藥物', '操作提示', {
    			// if you want to disable its autofocus
    			// autofocus: false,
    			confirmButtonText: 'OK'
  })
				}
				else{
					this.$router.push({name:"dishview",params:{no:this.dishNo}});
				
				}
				
			}
		}
	}
</script>

<style>
</style>