<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 一般弹窗 Modal -->
<div class="md-modal colored-header md-effect-10" id="colored-primary">
	<div class="md-content">
		<div class="modal-header text-center">
			<h3></h3>
			<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
		</div>
		<div class="modal-body">
			<div class="text-center">
				<div class="form-horizontal" role="form">
				    <div class="form-group">
				        <label for="category-name" class="col-sm-2 col-md-2 control-label">类别名称</label>
				        <div class="col-sm-10 col-md-10">
				            <input type="text" class="form-control" id="category-name">
				        </div>
				    </div>
				    <div class="form-group">
				        <label for="category-weight" class="col-sm-2 col-md-2 control-label">类别权重</label>
				        <div class="col-sm-10 col-md-10">
				            <input type="text" class="form-control" id="category-weight">
				        </div>
				    </div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-success btn-flat md-close" data-dismiss="modal">保存</button>
			<button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal">取消</button>
		</div>
	</div>
</div>
<!-- 删除弹窗 Modal -->
<div class="md-modal colored-header danger md-effect-10" id="colored-danger">
	<div class="md-content">
		<div class="modal-header text-center">
			<h3>确定要删除该条记录</h3>
			<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
		</div>
		<div class="modal-body">
			<div class="text-center">
				<div class="i-circle danger"><i class="fa fa-times"></i></div>
				<h4>删除后数据无法恢复，请慎重选择</h4>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-danger btn-flat md-close" data-dismiss="modal">确定</button>
			<button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal">取消</button>
		</div>
	</div>
</div>
<div class="md-overlay"></div>