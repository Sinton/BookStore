<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="public/head.jsp" />
</head>
<body>
<jsp:include page="public/navbar.jsp" />
<div class="container">
    <div class="row">
        <!-- 面包屑导航 -->
        <!-- <div class="col-sm-12 col-md-12">
            <ol class="breadcrumb" style="margin-top: 10px;">
                <li><a href="#">编程语言与程序设计</a></li>
                <li><a href="#">Java</a></li>
                <li><a href="#">深入理解Java虚拟机：JVM高级特性与最佳实践（第2版）</a></li>
            </ol>
        </div> -->
        <!-- 书籍详细信息 -->
        <div class="col-sm-12 col-md-12" style="margin-top: 10px;">
            <div class="row">
                <div class="col-sm-5">
                    <div class="thumbnail">
                        <img src="upload/${book.getImgUrlBig()}" alt="...">
                    </div>
                </div>
                <div class="col-sm-7">
                    <blockquote>
                        <h4>${book.getName()}</h4>
                        <small><label class="label label-success">${book.getAuthor() }</label> 著</small>
                    </blockquote>
                    <div class="well">
                        <div>现 价：<span style="color: #c9302c;font-size: 20px">¥${book.getDiscount() * (book.getPrice() / 10) }</span> [${book.getDiscount()}折]</div>
                        <div>　</div>
                        <div>定 价：<s class="bg-danger">￥${book.getPrice()}</s></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            购买数量：
                            <div class="btn-group">
                                <a href="#" class="btn btn-default disabled"><i class="glyphicon glyphicon-arrow-down"></i></a>
                                <a href="#" class="btn btn-default disabled">1</a>
                                <a href="#" class="btn btn-default"><i class="glyphicon glyphicon-arrow-up"></i></a>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <a href="cart.do?bid=${book.getBid()}" class="btn btn-danger"><i class="glyphicon glyphicon-shopping-cart"></i> 加入购物车</a>
                        </div>
                    </div>
                    <br>
                    温馨提示：支持7天无理由退货
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-12">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#intro" data-toggle="tab" aria-expanded="true">商品介绍</a></li>
                <li><a href="#evel" data-toggle="tab" aria-expanded="true">管理员评论</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane" id="evel">
                    <div class="col-sm-12">　</div>
                    <div class="col-sm-12">这书好，推荐看</div>
                </div>
                <div class="tab-pane fade active in" id="intro">
                    <div class="col-sm-12">　</div>
                    <div class="col-sm-3">出版社： ${book.getPublishing()}</div>
                    <div class="col-sm-3">ISBN：${book.getIsnb()}</div>
                    <div class="col-sm-3">版次：${book.getEdition()}</div>
                    <div class="col-sm-3">包装：平装</div>
                    <div class="col-sm-3">开本：16</div>
                    <div class="col-sm-3">开出版时间：${book.getPublishTime()}</div>
                    <div class="col-sm-3">页数：${book.getPageNum()}</div>
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-12">
            <img class="center-block" style="padding: 20px 20px 20px 20px;" src="img/ad.jpg" alt="">
        </div>
        <div class="col-sm-12 col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">编辑推荐</div>
                <div class="panel-body">
                    <p>超级畅销书全新升级，第1版两年内印刷近10次，Java图书领域公认的经典著作，繁体版台湾发行</p>
                    <p>1.7，围绕内存管理、执行子系统、程序编译与优化、高效并发等核心主题对JVM进行全面而深入的分析，深刻揭示JVM的工作原理</p>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">内容简介</div>
                <div class="panel-body">
                    <p>本书第1版两年内印刷近10次，4家网上书店的评论近4?000条，98%以上的评论全部为5星级的好评，是整个Java图书领域公认的经典著作和超级畅销书，繁体版在台湾也十分受欢迎。第2版在第1版的基础上做了很大的改进：根据全新的JDK 1.7对全书内容进行了全面的升级和补充；增加了大量处理各种常见JVM问题的技巧和优佳实践；增加了若干与生产环境相结合的实战案例；对第1版中的错误和不足之处的修正；等等。第2版不仅技术更新、内容更丰富，而且实战性更强。</p>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">作者简介</div>
                <div class="panel-body">
                    <p><b>周志明</b>，资深Java技术专家，对JavaEE企业级应用开发、OSGi、Java虚拟机和工作流等都有深入的研究，并在大量的实践中积累了丰富的经验。尤其精通Java虚拟机，撰写了大量与JVM相关的经典文章，被各大技术社区争相转载，是ITeye等技术社区公认的Java虚拟机方面的领袖人物之一。除本书外，还著有经典著作本书，广获读者好评。现任远光软件股份有限公司开发部总经理兼架构师，先后参与过国家电网、南方电网等多个大型ERP项目的平台架构工作，对软件系统架构也有深刻的认识和体会。</p>
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-12">
		    <h4 class="text-danger">正品行货</h4>
		    工大 E 书城城向您保证所售商品均为正品行货，工大 E 书城商品开具机打发票或电子发票。
		    <h4 class="text-danger">全国联保</h4>
		    凭质保证书及工大 E 书城城发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由工大 E 书城系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。工大 E 书城城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！
		    <hr>
		    注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
		</div>
        <jsp:include page="public/footer.jsp" />
    </div>
</div>
</body>
</html>