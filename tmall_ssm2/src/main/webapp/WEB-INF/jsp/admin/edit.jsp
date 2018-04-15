<div class="panel panel-warning addDiv">
<div class="panel-heading">编辑分类</div>
    <div class="panel-body">
        <form method="post" id="editForm" action="admin_category_update" enctype="multipart/form-data">
            <table class="editTable">
                <tr>
                    <td>分类名称</td>
                    <td><input id="name" name="name" value="${c.name}" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td>分类图片</td>
                    <td>
                        <input id="categoryPic" accept="image/*" type="file" name="image"/>
                    </td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="id" value="${c.id}">
                        <button type="submit" class="btn btn-success" >提交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>