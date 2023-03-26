<template>
<div class="wrapper">
	<TopArea></TopArea>
	<LeftMenu></LeftMenu>
  

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
    
    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <router-view></router-view>            
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <FootArea></FootArea>
  
</div>
<!-- ./wrapper -->
</template>

<script>
import { RouterLink, RouterView } from 'vue-router'
import TopArea from "./components/common/toparea.vue"
import LeftMenu from "./components/common/leftmenu.vue"
import FootArea from "./components/common/footarea.vue";
export default {
	name:"App",
	data(){
		return {
			title:"系统功能"
		}
	},
	components:{
		TopArea,LeftMenu,FootArea
	}
}

</script>



<style>
 @import url("assets/plugins/fontawesome-free/css/all.min.css");
 @import url("assets/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css");
 @import url("assets/plugins/datatables-responsive/css/responsive.bootstrap4.min.css");
 @import url("assets/plugins/datatables-buttons/css/buttons.bootstrap4.min.css");
 @import url("assets/dist/css/adminlte.min.css");
 .CRSelectedBG {
 	 background-color:#B1BBC4;
 }
 
</style>
