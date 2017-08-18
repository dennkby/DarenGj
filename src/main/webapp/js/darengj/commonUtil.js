/**
 * Created by Tony on 2016/8/30.
 */
function popTip(data){
    var a = "<div class='modal fade' id='popTip' tabindex='-1'  role='dialog' aria-labelledby='head'>" +
                "<div class='modal-dialog' role='document'>" +
                    "<div class='modal-content'>" +
                        "<div class='modal-header'>"+
                            "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>×</span></button>"+
                            "<h4 class='modal-title' id='head'>"+(data.title||'提示')+"</h4>"+
                        "</div>"+
                        "<div class='modal-body'>"+data.content+"</div>"+
                    "</div>"+
                "</div>" +
            "</div>";
    $('body').append(a)
    $("#popTip").find(".modal-dialog").css({
        width:(data.width||300)+"px",
        height:(data.height||150)+"px"
    })
    $("#popTip").find(".modal-content").css({
        height:(data.height||150)+"px"
    })
    $("#popTip").modal();
}