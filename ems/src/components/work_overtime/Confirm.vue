<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 1200px">
            <el-table-column
                    fixed
                    prop="apply_time"
                    label="申请时间"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="epnum"
                    label="工号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="o_type"
                    label="加班类型"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="o_start"
                    label="加班开始时间"
                    width="160">
            </el-table-column>
            <el-table-column
                    prop="o_end"
                    label="加班结束时间"
                    width="160">
            </el-table-column>
            <el-table-column
                    prop="o_descrip"
                    label="加班描述"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="o_comfirm_descrip"
                    label="审批描述"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="o_confirm_person"
                    label="审批人"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="审批状态"
                    width="100">
                <template #default="scope">
                    <el-button @click="handleClick(scope.row)" type="text">审批</el-button>

                </template>
            </el-table-column>
        </el-table>
    </div>

</template>

<script>
    /* eslint-disable */
    export default {
        name: "Confirm",
        data() {
            return {
                tableData: [{
                    epnum: 20210001,
                    o_type: 1,
                    o_start: '',
                    o_end: '',
                    o_total: 300,
                    o_descrip: 'text',
                    o_mark: '通过',
                    o_confirm_person: '',
                    o_comfirm_descrip: '',
                    apply_time: '2020-06-03 00:00:00',
                },
                ],
                emptable: {
                    epnum: 20210001,
                    o_type: 1,
                    o_start: '',
                    o_end: '',
                    o_total: 300,
                    o_descrip: 'text',
                    o_mark: '通过',
                    o_confirm_person: '',
                    o_comfirm_descrip: '',
                    apply_time: '2020-06-03 00:00:00',
                },
                id:'',

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

                this.tableGet();
            },
            handleClick(row) {
              /*  this.emptable.apply_time = row.apply_time;
                this.epnum = row.ep*/
                console.log("审批调试")
                console.log(row.apply_time)

                console.log("审批调试")
                this.$router.push({path:'/ConfirmTable',query:{
                        id : this.id,
                        epnum: row.epnum,
                        o_type: row.o_type,
                        o_start: row.o_start,
                        o_end: row.o_end,
                        o_total: row.o_total,
                        o_descrip: row.o_descrip,
                        o_mark: row.o_mark,
                        o_confirm_person: row.o_confirm_person,
                        o_comfirm_descrip: row.o_comfirm_descrip,
                        apply_time: row.apply_time}});
            },
            tableGet(){
                this.$http.get("http://localhost:8081/ems/employee/getOvertimeCheck?id=" + this.id).then((res) => {
                    this.tableData = res.data;
                    console.log(this.tableData);


                    if (this.tableData.length == 0) {
                        this.flag = 0;
                    } else {
                        this.flag = 1;
                        for (let i = 0; i < this.tableData.length; i++) {
                            if (this.tableData[i].o_mark == '0') {
                                this.tableData[i].o_mark = "未审批"
                            } else if (this.tableData[i].o_mark == '1') {
                                this.tableData[i].o_mark = "通过"
                            } else if (this.tableData[i].o_mark == '2') {
                                this.tableData[i].o_mark = "未通过"
                            }
                        }
                    }
                })
            }

        },

    }
</script>

<style scoped>

</style>
