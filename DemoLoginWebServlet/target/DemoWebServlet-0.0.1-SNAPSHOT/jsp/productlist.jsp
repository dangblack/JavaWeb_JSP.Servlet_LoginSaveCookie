<div class="container">
    <h2>My Product List</h2>

    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">

    <table id="myTable">
        <tr class="header">
            <th style="width:20%;">ID</th>
            <th style="width:30%;">Name</th>
            <th style="width:20%;">Price</th>
            <th style="width:15%;">Edit</th>
            <th style="width:15%;">Delete</th>
        </tr>
        <tr>
            <td>1</td>
            <td>abcd</td>
            <td>15000</td>
            <td>
                <div class="row">
                    <div class="col-sm-6">
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
                            <div class="fa fa-edit"></div>
                        </button>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h2 class="modal-title">Update</h2>
                            </div>
                            <div class="modal-body">
                                <form action="" method="POST" role="form">
                                    <div class="form-group">
                                        <label for="">Input Id</label>
                                        <input type="text" class="form-control" id="" placeholder="Input id...">

                                        <label for="">Input Name</label>
                                        <input type="text" class="form-control" id="" placeholder="Input tên...">

                                        <label for="">Input Price</label>
                                        <input type="text" class="form-control" id="" placeholder="Input price...">
                                    </div>

                                    <button type="submit" class="btn btn-primary">Save</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <div class="row">
                    <div class="col-sm-6">
                        <button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#myModal2">
                            <div class="fa fa-trash"></div>
                        </button>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="myModal2" role="dialog">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Do you want to delete?</h4>
                            </div>
                            <div class="modal-body">
                                <p>If you delete, data will be lost</p>
                            </div>
                            <div class="modal-footer">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <button type="button" class="btn btn-danger">Delete</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>

    </table>
</div>