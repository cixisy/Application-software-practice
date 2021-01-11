<template>
    <div style="width:800px;margin-left: 50px">
        <el-table
                :data="tableData"
                style="width: 100%"
                height="400"  highlight-current-row="true">
            <el-table-column
                    prop="apply_time"
                    label="日期"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="申请人"
                    width="150">
            </el-table-column>
			<el-table-column
			        prop="l_type"
			        label="请假类型"
			        width="150">
			</el-table-column>
            <el-table-column
                    prop="l_descrip"
                    label="请假描述"
                    width="250">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template #default="scope">
                    <el-button @click="toDetails(scope.row)" type="text" size="small">查看</el-button>
					<el-button
					          @click="check(scope.$index, tableData)"
					          type="text"
					          size="small">
					          审批
					        </el-button>
                </template>
            </el-table-column>
        </el-table>
        </div>
		
		<el-dialog title="审批" v-model="dialogVisible" width="400px">
		    <el-form ref="form" :model="form" label-width="80px">
		        <el-form-item label="审批描述">
		            <el-input v-model="form.l_descrip"></el-input>
		        </el-form-item>
		        <el-form-item label="是否通过" prop="type" required>
		         
		              <el-radio v-model="form.type" label="1">通过</el-radio>
		              <el-radio v-model="form.type" label="2">不通过</el-radio>
		        		
		          </el-form-item>
		    </el-form>
		    <span  class="dialog-footer">
		    <el-button @click="dialogVisible = false">取 消</el-button>
		    <el-button type="primary" @click="confirm">确 定</el-button>
		  </span>
		</el-dialog>
</template>

<script lang="js">
	/* eslint-disable */
    import {defineComponent} from 'vue'

    export default defineComponent({
        name: "LeaveCheck",
        data() {
            return {
				id:'',
				index:'',
				row:{},
				dialogVisible:false,
                tableData: [],
				form:{
					l_descrip:'',
					type:'1'
				},
				name:''
            }
        },
		beforeRouteEnter: (to, from, next) => {
			next(vm => {
				vm.getParams();
			});
		},
        methods:{
			getParams() {
				this.id = this.$route.query.id;
				this.$http.get("http://localhost:8081/ems/employee/queryLeaveCheckList?id=" + this.id).then((res) => {
					this.tableData = res.data;
					if (this.tableData.length == 0) {
						this.flag = 0;
					} else {
						this.flag = 1;
						for (let i = 0; i < this.tableData.length; i++) {
							if (this.tableData[i].l_type == '1') {
								this.tableData[i].l_type = "事假"
							} else if (this.tableData[i].l_type == '2') {
								this.tableData[i].l_type = "病假"
							} else if (this.tableData[i].l_type == '3') {
								this.tableData[i].l_type = "出差"
							} else if (this.tableData[i].l_type == '4') {
								this.tableData[i].l_type = "带薪休假"
							}
							
							this.$http.get("http://localhost:8081/ems/employee/queryNameById?id=" + this.tableData[i].epnum).then((res)=>{
								this.tableData[i].name = res.data
							})
						}
					}
				})
				
				this.$http.get("http://localhost:8081/ems/employee/queryNameById?id=" + this.id).then((res)=>{
					this.name = res.data
				})
				
				},
            toDetails(row){
                this.$router.push({path:'/leavedetails',query:{
                	apply_time :  row.apply_time,
                	epnum : row.epnum,
                	l_type : row.l_type,
                	l_start : row.l_start,
                	l_end : row.l_end,
                	l_descrip : row.l_descrip,
                	leave_comfirm_descrip : row.leave_comfirm_descrip
                }})
            },
            check(index,row){
				this.dialogVisible = true;
				this.index = index;
				this.row =  row;
                
            },
			confirm(){
				let index = this.index;
				let row = this.row;
				this.$http.get("http://localhost:8081/ems/employee/insertCheckInfo?name=" + this.name + "&desc=" + this.form.l_descrip
				+ "&type=" + this.form.type + "&id=" + row[index].epnum + "&date=" + row[index].apply_time).then((res)=>{
						this.$confirm('是否提交审批信息', '提示', {
						    confirmButtonText: '确定',
						    cancelButtonText: '取消',
						    type: 'warning'
						}).then(() => {
							this.$alert('申请已提交！', '提示', {
							  confirmButtonText: '确定',
							  callback: action => {
							    this.$message({
							        type: 'success',
							        message: '提交成功!'
							    });
							  }
							});
							row.splice(index, 1);
						}).catch(() => {
						    this.$message({
						        type: 'info',
						        message: '已取消'
						    });
						});
				})
				this.dialogVisible = false;
			}
        }
    })
</script>

<style scoped>

</style>