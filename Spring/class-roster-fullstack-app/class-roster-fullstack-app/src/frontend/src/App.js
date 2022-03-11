import './App.css';
import StudentDrawerForm from "./StudentDrawerForm";
import EditStudentDrawerForm from "./EditStudentDrawerForm";
import { useAppContext } from "./context/appContext";

import {
    Layout,
    Menu,
    Breadcrumb,
    Table,
    Spin,
    Empty,
    Button,
    Popconfirm, Select,
} from 'antd';
import {
  PieChartOutlined,
  TeamOutlined,
  UserOutlined,
  PlusOutlined
} from '@ant-design/icons';

const {Header, Content, Footer, Sider} = Layout;
const {SubMenu} = Menu;
const { Option } = Select;

function App() {
    const {
        students,
        fetchStudents,
        isCollapsed,
        isLoading,
        openEditDrawer,
        openDrawer,
        toggleSider,
        deleteStudent,
        cancelConfirm,
    } = useAppContext();

    const columns = () => [
        {
            title: 'Id',
            dataIndex: 'id',
            key: 'id',
        },
        {
            title: 'Name',
            dataIndex: 'name',
            key: 'name',
        },
        {
            title: 'Email',
            dataIndex: 'email',
            key: 'email',
        },
        {
            title: 'Gender',
            dataIndex: 'gender',
            key: 'gender',
        },
        {
            title: 'Actions',
            key: 'actions',
            render: (text, student) => (
                <>
                    <Popconfirm
                        title={`Are you sure you want to delete student with id of ${student.id}`}
                        onConfirm={() => deleteStudent(student.id)}
                        onCancel={cancelConfirm}
                        okText="Yes"
                        cancelText="No">
                        <Button type="default" size="small">
                            Delete
                        </Button>
                    </Popconfirm>
                    <Button type="default" size="small" onClick={() => openEditDrawer(student.id)}>
                        Edit
                    </Button>
                </>
            ),
        }
    ];

  const renderStudents = () => {
    if(isLoading){
      //return <Spin />
    }

    if(students == null){
      return <>
          <Empty />
          <Button id="no-data-button" type="primary" shape="round" icon={<PlusOutlined />} size='medium' onClick={() => openDrawer}>Add New Student</Button>
          <StudentDrawerForm />
      </>
    }

    return <>
        <StudentDrawerForm />
        <EditStudentDrawerForm />
        <Table dataSource={students}
               columns={columns(fetchStudents)}
               bordered
               title={() => <Button type="primary" shape="round" icon={<PlusOutlined />} size='medium' onClick={() => openDrawer()}>Add New Student</Button>}
               pagination={{ pageSize: 25 }}
               scroll={{ y: 500 }}
               rowKey={(student) => student.id}
        />
    </>
  }

  return <Layout style={{minHeight: '100vh'}}>
        <Sider collapsible collapsed={isCollapsed}
               onCollapse={toggleSider}>
            <div className="logo"/>
            <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                <Menu.Item key="1" icon={<TeamOutlined/>}>
                    Roster
                </Menu.Item>
            </Menu>
        </Sider>
        <Layout className="site-layout">
            <Header className="site-layout-background" style={{padding: 0}}/>
            <Content style={{margin: '0 16px'}}>
                <Breadcrumb style={{margin: '16px 0'}}>
                    <Breadcrumb.Item>Roster</Breadcrumb.Item>
                    <Breadcrumb.Item>Students</Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-background" style={{padding: 24, minHeight: 360}}>
                  {renderStudents()}
                </div>
            </Content>
            <Footer style={{textAlign: 'center'}}>&copy; Copyright 2022</Footer>
        </Layout>
    </Layout>
}

export default App;
