<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>左侧导航栏</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="../css/page.css" />
    <link href="../plugins/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="../plugins/css/icons.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page" id="app">
    <div class="nav-left" v-show="navLeftFlag" ref="navLeft">
        <div class="LogoName">
            社区进出管理系统
        </div>
        <div class="navDiv">
            <div class="navName">导航</div>
            <div class="nav-list">
                <ul>
                    <li class="nav-tab a_active waves-effect">
                        <a href="home.jsp" class="li-a active" target="iframe"><i class='bx bx-home-smile'></i> 首页
                            <span class="badge badge-pill badge-primary float-right">3</span>
                        </a>
                    </li>

                    <li class="nav-tab nav-ul">
                        <a href="javascript:void[0]" class="li-a" target="iframe">
                            <i class='bx bx-layer'></i> 进出管理
                            <i class='bx bx-chevron-right' style="float: right;"></i>
                        </a>
                        <div class="nav-box">
                            <a href="recordpage.jsp" class="li-a-a" target="iframe">
                                进出查询
                            </a>
                            <a href="submitrecordpage.jsp" class="li-a-a" target="iframe">
                                进出登记
                            </a>
                        </div>
                    </li>
                    <li class="nav-tab nav-ul">
                        <a href="javascript:void[0]" class="li-a">
                            <i class='bx bx-buildings'></i>
                            隔离信息
                            <i class='bx bx-chevron-right' style="float: right;"></i>
                        </a>
                        <div class="nav-box">
                            <a href="quarantinepeople.jsp" class="li-a-a" target="iframe">查询隔离人员</a>
                            <a href="submitquarantine.jsp" class="li-a-a" target="iframe">登记隔离人员</a>
                        </div>
                    </li>
                    <li class="nav-tab nav-ul">
                        <div>
                            <a href="map.jsp" class="li-a" target="iframe">
                                <i style="float:left; margin-right: 7px; margin-top: 1px; margin-left: 1px"><img src="../images/map.png"></i> 疫情地图
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/logout.do"><button id="logout_button">退出登录</button></a>
    </div>

    <div class="nav-right" ref="navRight">
        <div class="nav-top">
            <button type="button" class="btn btn-primary btn-sm hiddenBtn" style="line-height: 10px;background: rgba(0,0,0,0);border: 0px" @click="isShowLeft">
                <i class="bx bx-grid-alt" style="font-size: 16px;"></i>
            </button>
            <a href="profilepage.jsp">
            <button type="button" style="background: rgba(0,0,0,0); border: 0px; font-size: 16px; color: white; float: right">个人中心</button>
            </a>
            <!-- <button type="button" class="btn btn-primary btn-sm showBtn" style="line-height: 10px; display: none;" onclick="showNavRight">
                <i class="bx bx-expand" style="font-size: 16px;"></i>
            </button> -->
        </div>
        <div class="content-page" ref="cPage">
            <iframe name="iframe" style="width: 100%; height: 100%; border: 0px; overflow: hidden;" src="home.jsp"></iframe>
        </div>
    </div>
</div>
<script src="../js/vue.min.js"></script>
<script src="../js/jquery.js"></script>
<script type="text/javascript">
    $(function() {
        let navflag = false;
        $('.nav-tab').click(function() {
            $(this).siblings().each(function() {
                $(this).removeClass('a_active');
                // $(this).removeClass('a_active');
                $(this).find('.nav-box').css('height', '0')
                //关闭右侧箭头
                if ($(this).attr('class').indexOf('nav-ul') != -1) {
                    $(this).find('.bx-chevron-right').css('transform', 'rotateZ(0deg)')
                    $(this).find('.bx-chevron-right').css('transition', 'all .5s')
                    $(this).removeClass('nav-show')
                    // $(this).find('div').removeClass('nav-box')
                }
            })
            //当前选中
            $(this).addClass('a_active')
            $(this).find('.li-a').addClass('active')
            // 打开右侧箭头
            $(this).find('.bx-chevron-right').css('transform', 'rotateZ(90deg)')
            $(this).find('.bx-chevron-right').css('transition', 'all .5s')
            $(this).addClass('nav-show')
            // $(this).find('div').addClass('nav-box')
        })
        /* 二级菜单a点击事件 */
        $(".li-a-a").click(function() {
            $(".li-a-a").each(function() {
                $(this).removeClass('active-li-a');
            })
            $(this).addClass('active-li-a');

        })

    })
    const vue = new Vue({
        el: '#app',
        data: {
            navLeftFlag: true
        },
        methods: {
            isShowLeft() {
                if (this.navLeftFlag ) {
                    this.$refs.navRight.style.paddingLeft = '0px'
                    this.$refs.cPage.style.left = '0px';
                    this.navLeftFlag = false;
                    // this.$refs.navLeft.style.width = '0px';
                    // setTimeout(()=>{
                    // 	this.navLeftFlag = false;
                    // },200)
                } else {
                    this.$refs.navRight.style.paddingLeft = '240px';
                    this.$refs.cPage.style.left = '240px';
                    this.navLeftFlag = true;
                    // this.$refs.navLeft.style.width = '240px';
                    // setTimeout(()=>{
                    // 	this.navLeftFlag = true;
                    // },200)
                }
            }
        }
    })
</script>
</body>
</html>
