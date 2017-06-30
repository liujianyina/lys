<!DOCTYPE html>
<html>
<head>
<#include "_header.ftl">
    <meta charset="UTF-8">
    <title></title>
<body>
<#include  "_nav.ftl">

<div id="content_index">
    <div id="content_top">
        <div id="content_top_left">
            <label>今日推荐</label>
            <hr/>
            <span class="small_title">肉类</span>
            <ul>
                <li>牛肉</li>
                <li>猪肉</li>
                <li>羊肉</li>
                <li>腊肉</li>
                <li>香肠</li>
                <li>肝心</li>
            </ul>
            <div style="width: 100%;height: 90px;"></div>
            <hr/>
            <span class="small_title">水产</span>
            <ul>
                <li>鲫鱼</li>
                <li>草鱼</li>
                <li>鲤鱼</li>
                <li>河虾</li>
                <li>鳝鱼</li>
                <li>海虾</li>
            </ul>
            <div style="width: 100%;height: 90px;"></div>
            <hr/>
            <span class="small_title">蔬菜</span>
            <ul>
                <li>白菜</li>
                <li>菠菜</li>
                <li>豌豆尖</li>
                <li>土豆</li>
                <li>青菜</li>
                <li>白萝卜</li>
            </ul>
            <div style="width: 100%;height: 90px;"></div>
            <hr/>
            <span class="small_title">野味</span>
            <ul>
                <li>野鸡</li>
                <li>野鸭</li>
                <li>田鸡</li>
                <li>蛇肉</li>
                <li>牛蛙</li>
                <li>肉龟</li>
            </ul>
            <div style="width: 100%;height: 90px;"></div>
            <hr/>
            <label>更多商品来店查看</label>
        </div>
        <div id="content_top_right"></div>
        <div style="height: 530px;"></div>
        <div id="content_sub">
            <div id="content_sub_title">外卖订餐</div>
            <hr/>
            <div id="choice">
                <div id="choice_button_div">
                    <button class="choice_button" onclick="choice1()">自选</button>
                    <button class="choice_button" onclick="choice2()">套餐</button>
                </div>
                <div id="personal">
                    <span class="small_title" style="color: gray;">选择配菜</span>
                    <div style="height: 50px;width: 100%;"></div>
                    <ul>
                        <li>
                            <div class="choice_div">
                                <img src="img/img1.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">海带50g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img2.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">鹌鹑蛋5个</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img3.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">生菜100g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img4.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">鲜肉片100g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img5.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">毛肚200g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img6.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">老肉片100g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img7.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">丸子100g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img8.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">生菜100g</p>
                            </div>
                        </li>
                        <li>
                            <div class="choice_div">
                                <img src="img/img8.jpg" class="choice_div_img"/>
                                <p class="choice_div_name">生菜100g</p>
                            </div>
                        </li>
                    </ul>
                    <div style="height: 700px;width: 1024px;"></div>
                    <span class="small_title" style="color: gray;">选择口味</span>
                    <div style="height: 50px;width: 100%;"></div>
                    <div id="choice_form_div">
                        <form id="choice_form_form">
                            <p>
                                <input type="radio" name="taste"/>微辣
                                <input type="radio" name="taste"/>中辣
                                <input type="radio" name="taste"/>变态辣
                            </p>
                            <button class="choice_button">提交</button>
                        </form>
                    </div>
                    <div style="height: 50px;width: 100%;"></div>
                </div>
                <div id="auto_chois">
                    <ul>
                    <#list setmealList as setmeal>
                        <li>
                            <div class="choice_div">
                                <a href="/system/buy?sid=${setmeal.sid}"><img src="${setmeal.imgurl}" class="choice_div_img"/></a>
                                <p class="choice_div_price">￥${setmeal.price}<sup
                                        class="choice_div_count">　剩余${setmeal.count}份</sup></p>
                                <p class="choice_div_name">${setmeal.cname}</p>
                            </div
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "_footer.ftl">
</body>
</head>
</html>