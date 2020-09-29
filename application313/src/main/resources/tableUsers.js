

function getUsersTable(num) {
    let newTable = '' ;
    newTable1 = '';
    let i = 0;
    let path = num==0 ? '/api/users' : '/api/currentUser' ;
    newTable = newTable1.concat("<div class='panel panel-primary'> " ,
        "<div class='panel-heading'>",
        "<h3 class='panel-title'>All users</h3>",
        "</div>",
        "<div class='panel panel-default'>",
        "<div class='panel-body bg-white'>",
        "<div class='panel-body'>",
        "<div class='panel panel-default'>",
        "<div class='panel-heading'></div>",
        "<table class='table table-striped'>",
        "<thead><tr>",
        "<td align='center'><b>ID</b></td>",
        "<td align='center'><b>FirstName</b></td>",
        "<td align='center'><b>LastName</b></td>",
        "<td align='center'><b>Mail</b></td>",
        "<td align='center'><b>Role</b></td>",
        "<td align='center'><b>Active</b></td>",
        "</tr></thead><tbody>") ;

    fetch(path)
        .then(function (response) {
            return response.json();
        }).then(usersList =>{
        Array.from( usersList, function (user) {
            stringRoles ='';
            Array.from(user.roles,function (role) {
                stringRoles += role.name + ' ';
            });
            newTable1 = '';
            newTable +=
                newTable1.concat("<tr><td align='center'>" , user.id , "</td>" ,
                    "<td align='center'>" , user.name , "</td>" ,
                    "<td align='center'>" , user.lastname , "</td>" ,
                    "<td align='center'>" , user.mail , "</td>" ,
                    "<td align='center'>" , stringRoles , "</td>" ,
                    "<td align='center'>" , user.active , "</td>" ,
                    "<td>",
                    "<input type='button' class='btn btn-info'  value='edit' " ,
                    "data-parameter1=" , user.id ,
                    " id='btnEdit' ",
                    " onClick=\"oneditclick(this.getAttribute('data-parameter1'))\">",
                    "" ,
                    "</input>" ,
                    "</td>" ,
                    "<td>",
                    "<input type='button' class='btn btn-danger'  value='delete'" ,
                    "data-parameter1=" , user.id  ,
                    " id='btnEdit' ",
                    " onClick=\"ondeleteclick(this.getAttribute('data-parameter1'))\">" ,
                    "" ,
                    "</input>" ,
                    "</td>" ,
                    "</tr>") ;
        });
        newTable1 = '';
        newTable += newTable1.concat(
            "</tbody></table>" ,
            "</div>" ,
            "</div>" ,
            "</div>" ,
            "</div>" ,
            "</div>");
        document.getElementById('blockTable').innerHTML = newTable;
        // console.log(newTable);
    });

}



function onClickChangeUser(num) {
    getUsersTable(num);
}

function oneditclick(uid) {
    $('#winModal').modal('show');
    fetch('/api/' + uid)
        .then(function (response) {
            return response.json();
        })
        .then(function (editUser) {
            document.getElementById("idEdit").setAttribute('value', editUser.id);
            document.getElementById("nameEdit").setAttribute('value', editUser.name);
            document.getElementById("lastnameEdit").setAttribute('value', editUser.lastname);
            document.getElementById("mailEdit").setAttribute('value', editUser.mail);
            document.getElementById("passwordEdit").setAttribute('value', '');
            document.querySelector("#btn_action").innerHTML = "Edit";
            $("#formModal").attr("action", "/edit");
            document.getElementById("passwordEdit").style.display = "inline";
            document.getElementById("passwordLabel").style.display = "inline";
        });

}

function ondeleteclick(uid) {
    $('#winModal').modal('show');
    fetch('/api/' + uid)
        .then(function (response) {
            return response.json();
        })
        .then(function (deleteUser) {
            document.getElementById("idEdit").setAttribute('value', deleteUser.id);
            document.getElementById("nameEdit").setAttribute('value', deleteUser.name);
            document.getElementById("lastnameEdit").setAttribute('value', deleteUser.lastname);
            document.getElementById("mailEdit").setAttribute('value', deleteUser.mail);
            document.querySelector("#btn_action").innerHTML = "Delete";
            $("#formModal").attr("action", "/delete");
            document.getElementById("passwordEdit").style.display = "none";
            document.getElementById("passwordLabel").style.display = "none";
        });
}




