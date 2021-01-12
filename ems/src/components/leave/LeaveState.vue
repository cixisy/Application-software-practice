<template>
	<div style="width:800px;margin-left: 50px">
		<el-table :data="tableData" style="width: 100%">
			<el-table-column prop="apply_time" label="日期" width="180">
			</el-table-column>
			<el-table-column prop="leave_confirm_person" label="审批人" width="180">
			</el-table-column>
			<el-table-column prop="leave_comfirm_descrip" label="审批描述" width="200">
			</el-table-column>
			<el-table-column prop="l_mark" label="审批状态">
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="100">
				<template #default="scope">
					<el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
					<el-button
							@click="deleteRow(scope.$index, tableData)"
							type="text"
							size="small">
						撤销
					</el-button>
					<!-- <el-button type="text" size="small" @click="delete(scope.row)">撤销</el-button> -->
				</template>
			</el-table-column>
		</el-table>
	</div>

</template>

<script lang="js">
	/* eslint-disable */
	import {
		defineComponent
	} from 'vue'

	export default defineComponent({
		name: "LeaveState",
		data() {
			return {
				id: '',
				flag: 0,
				tableData: [{

				}
				],
				list:{}
			}
		},
		beforeRouteEnter: (to, from, next) => {
			next(vm => {
				vm.getParams();
			});
		},
		methods: {
			getParams() {
				this.id = this.$route.query.id;
				console.log(this.id);

				this.$http.get("http://localhost:8081/ems/employee/queryCurrentLeaveInfo?id=" + this.id).then((res) => {
					this.tableData = res.data;
					if (this.tableData.length == 0) {
						this.flag = 0;
					} else {
						this.flag = 1;
						for (let i = 0; i < this.tableData.length; i++) {
							if (this.tableData[i].l_mark == '0') {
								this.tableData[i].l_mark = "未审批"
							} else if (this.tableData[i].l_mark == '1') {
								this.tableData[i].l_mark = "通过"
							} else if (this.tableData[i].l_mark == '2') {
								this.tableData[i].l_mark = "未通过"
							}
						}
					}
				})
			},
			handleClick(row) {
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
			deleteRow(index,row){
				console.log("进入 delete")
				console.log(index)
				console.log(row)
				this.$confirm('是否撤销请假信息', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.$http.get("http://localhost:8081/ems/employee/deleteOneLeaveInfo?id=" + row[index].epnum  + "&date=" + row[index].apply_time)
							.then((res)=>{
								this.$alert('申请已撤销！', '提示', {
									confirmButtonText: '确定',
									callback: action => {
										this.$message({
											type: 'success',
											message: '撤销成功!',
										});
									},
								});
								row.splice(index, 1);
							});


				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消'
					});
				});
			}
		}
	})
</script>

<style scoped>

</style>
