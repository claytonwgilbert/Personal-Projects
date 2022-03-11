import {Drawer, Form, Button, Col, Row, Input, Select, Spin} from 'antd';
import {useAppContext} from "./context/appContext";

const { Option } = Select;

function StudentDrawerForm(){
    const {
        showDrawer,
        closeDrawer,
        isSubmitting,
        createNewStudent,
        createNewStudentFailed,
    } = useAppContext();

    return (
        <Drawer
            title="Create new student"
            width={720}
            onClose={closeDrawer}
            visible={showDrawer}
            bodyStyle={{paddingBottom: 80}}
            footer={
                <div style = {{textAlign: 'right'}}>
                    <Button onClick={closeDrawer} style={{marginRight: 8}}>
                        Close
                    </Button>
                </div>
            }>
            <Form layout="vertical"
                    onFinish={createNewStudent}
                    onFinishFailed={createNewStudentFailed}
                    hideRequiredFailed>
                <Row gutter={16}>
                    <Col span={12}>
                        <Form.Item
                            name="name"
                            label="Name"
                            rules={[{required: true, message: 'Please enter student name'}]}
                        >
                            <Input placeholder="Please enter student name"/>
                        </Form.Item>
                    </Col>
                    <Col span={12}>
                        <Form.Item
                            name="email"
                            label="Email"
                            rules={[{required: true, message: 'Please enter student email'}]}
                        >
                            <Input placeholder="Please enter student email"/>
                        </Form.Item>
                    </Col>
                </Row>
                <Row gutter={16}>
                    <Col span={12}>
                        <Form.Item
                            name="gender"
                            label="Gender"
                            rules={[{required: true, message: 'Please select student gender'}]}
                        >
                            <Select placeholder="Please select student gender">
                                <Option value="MALE">Male</Option>
                                <Option value="FEMALE">Female</Option>
                                <Option value="OTHER">Other</Option>
                            </Select>
                        </Form.Item>
                    </Col>
                </Row>
                <Row gutter={16}>
                    <Col span={12}>
                        <Form.Item>
                            <Button type="primary" htmlType="submit">
                                Submit
                            </Button>
                        </Form.Item>
                    </Col>
                </Row>
                <Row>
                    {isSubmitting && <Spin />}
                </Row>
            </Form>
        </Drawer>
    );
}

export default StudentDrawerForm;