var main = {
    init :  function () {
        var_this = this;
        //btn-save란 id를 가진 html엘리먼트에 click이벤트가 발생할 때, update function 실행하도록 이벤트 등록
        $('#btn-save').on('click',function () {
            _this.save();
        });
        $('#btn-update').on('click',function () {
            _this.update();
        });
        $('#btn-delete').on('click',function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title : $("#title").val(),
            author : $("#author").val(),
            content : $("#content").val()
        };

        $.ajax({
            type : 'POST',
            //http method : create - POST, read - GET, update - PUT, delete - DELETE
            url : '/api/v1/posts',
            dataType : 'json',
            contentType : 'application/json; charset=UTF-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('registered document');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    update : function() {
        var data = {
            title : $("#title").val(),
            content : $("#content").val()
        };

        var id = $("#id").val();

        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('modified document');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    delete : function () {
        var id = $("#id").val();

        $.ajax({
            type : 'DELETE',
            //http method : create - POST, read - GET, update - PUT, delete - DELETE
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=UTF-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('deleted document');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();