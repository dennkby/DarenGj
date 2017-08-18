/**
 * Created by Tony on 2016/8/29.
 */
$(function(){
    personal.init();
})
var personal = {
    init:function(){
        this.events();
    },
    events:function(){
        $("#add_title").unbind("click").bind("click",function(){
            $('<span class="label label-warning title_con">'+$("#title_txt").val()+'</span>').appendTo($("#title_lables"));
            $('.label-warning').unbind("click").bind("click",function(){
                $(this).remove();
            })
        });
        $("#add_sub_title").unbind("click").bind("click",function(){
            $('<span class="label label-danger sub_title_con">'+$("#sub_title_txt").val()+'</span>').appendTo($("#sub_title_lables"))
            $('.label-danger').unbind("click").bind("click",function(){
                $(this).remove();
            })
        })
        $("#query_btn").unbind("click").bind("click",function(){
            var page_num = 1;
            var page_size = 10;
            personal.request_data(page_num,page_size);
        })
        $("#next").unbind("click").bind("click",function(){
            $("#page_num").attr("num",parseFloat($("#page_num").attr("num"))+1);
            $("#page_num").text("第"+parseInt($("#page_num").attr("num"))+"页");
            var page_num = $("#page_num").attr("num");
            var page_size = 10;
            personal.request_data(page_num,page_size);
        });
        $("#previous").unbind("click").bind("click",function(){
            if($("#page_num").attr("num")>1) {
                $("#page_num").attr("num",parseFloat($("#page_num").attr("num"))-1);
                $("#page_num").text("第"+parseInt($("#page_num").attr("num"))+"页");
                var page_num = $("#page_num").attr("num");
                var page_size = 10;
                personal.request_data(page_num, page_size);
            }
        })
    },
    
    request_data:function(page_num,page_szie){
        var title = "";
        for(var i = 0;i<$(".title_con").length;i++){
            title+=$(".title_con").eq(i).text()+",";
        }
        var sub_title = "";
        for(var i = 0;i<$(".sub_title_con").length;i++){
            sub_title+=$(".sub_title_con").eq(i).text()+",";
        }
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/DarenGj/getAlbum.do",
            data: {title:title,sub_title:sub_title,page_size:page_szie,page_num:page_num},
            dataType:"json",
            async: false,
            success:function(data){
                $('#data_table').find("tbody").empty();
                var list = data.albumList;
                for(var i=0;i<list.length;i++){
                    var newRow=
                        '<tr class="">' +
                        '<td class="col-md-2"><div style="height: 100px;overflow-y: hidden">'+list[i].title+'</div></td>' +
                        '<td class="col-md-2"><div style="height: 100px;overflow-y: hidden">'+list[i].sub_title+'</div></td>' +
                        '<td class="col-md-2"><div style="height: 100px;overflow-y: hidden">'+list[i].author+'</div></td>' +
                        '<td class="col-md-2"><div style="height: 100px;overflow-y: hidden">'+list[i].like_num+'</div></td>' +
                        '<td class="col-md-2"><div style="height: 100px;overflow-y: hidden"><img src="'+list[i].cover_pic+'" class="img-thumbnail" style="width: 200px;height: 100px" alt=""></div></td> ' +
                        '<td class="col-md-2"><div style="height: 100px;overflow-y: hidden"><a href='+list[i].link+'>'+list[i].link+'</a></div></td> </tr>';
                    $('#data_table').append($(newRow));
                }
            },
            error:function(){

            }
        })
    }
}
