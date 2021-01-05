<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 1200px">
            <el-table-column
                    fixed
                    prop="applytime"
                    label="申请时间"
                    width="160">
            </el-table-column>
            <el-table-column
                    prop="epnum"
                    label="工号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="otype"
                    label="加班类型"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="ostart"
                    label="加班开始时间"
                    width="160">
            </el-table-column>
            <el-table-column
                    prop="oend"
                    label="加班结束时间"
                    width="160">
            </el-table-column>
            <el-table-column
                    prop="odescrip"
                    label="加班描述"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="ocomfirmdescrip"
                    label="审批描述"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="oconfirmperson"
                    label="审批人"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    prop="omark"
                    label="审批状态"
                    width="100">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "WorkOvertimeAuditStatus",
        data() {
            return {
                tableData: [{
                    epnum : 1,
                    otype : 1,
                    ostart : '',
                    oend :'',
                    ototal : 300,
                    odescrip :'text',
                    omark :0,
                    oconfirmperson :'',
                    ocomfirmdescrip :'',
                    applytime : '2020-06-03 00:00:00',
                },
                    {
                        epnum : 1,
                        otype : 1,
                        ostart : '',
                        oend :'',
                        ototal : 300,
                        odescrip :'text',
                        omark :0,
                        oconfirmperson :'',
                        ocomfirmdescrip :'',
                        applytime : '2020-06-03 00:00:00',
                    },],

            }
        },
        methods: {
            handleClick(row) {
                console.log(row);
            }
        },
    }
</script>

<style scoped>

</style>
