function load() {
    console.log(staffList);
    var staffArray = JSON.parse(staffList);
    var content = '<table class="table table-striped">\n' +
        '    <thead>\n' +
        '      <tr>\n' +
        '        <th>Username</th>\n' +
        '        <th>Fullname</th>\n' +
        '        <th>Email</th>\n' +
        '        <th>Role</th>\n' +
        '        <th>Save</th>\n' +
        '        <th>Delete</th>\n' +
        '      </tr>\n' +
        '    </thead><tbody>';
    for (var i = 0, len = staffArray.length; i < len; ++i) {
        console.log(staffArray[i]);
        var staff = staffArray[i];
        content += '<tr id = staff-{0}>';
        content += '    <td id="staff-name-{0}">' + staff["username"] + '</td>';
        content += '    <td id="staff-full-name-{0}">' + staff["userFullName"] + '</td>';
        content += '    <td id="staff-mail-{0}">' + staff["email"] + '</td>';
        content += '    <td><select id="staff-role-{0}" class="form-control">';
        var roles = JSON.parse(roleList);
        for (var j = 0, len1 = roles.length; j < len1; ++j) {
            var role = roles[j];
            content += String.format('<option value="{0}">{1}</option>', role["roleId"], role["roleName"]);
        }
        content += '</select></td>';
        content += '<td><button class="col-lg-1" type="button" style="display: inline" onclick="saveStaff({0});"><img src="web-dev/img/save.png" width="40"/></button></td>';
        content += '<td><button class="col-lg-1" type="button" style="display: inline" onclick="deleteStaff({0});"><img src="web-dev/img/delete.png" width="40"/></button></td>';
        content += '</tr>';
        content = String.format(content, staff["id"]);
    }
    content += '</tbody>\n' +
        '  </table>';

    document.getElementById('listStaff').innerHTML = content;
}